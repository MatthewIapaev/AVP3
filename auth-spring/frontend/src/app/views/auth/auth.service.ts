import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BehaviorSubject, Observable} from "rxjs";
import {map} from "rxjs/operators";

type Profile = {
  username: string
}

@Injectable({
  providedIn: 'root'
})
export class AuthService implements OnInit {
  get profile$(): BehaviorSubject<Profile> {
    return this._profile$;
  }

  private _profile$: BehaviorSubject<Profile>;

  constructor(private _http: HttpClient) {
    this._profile$ = new BehaviorSubject<Profile>(null);
  }

  signup(body: { username: string, password1: string, password2: string }) {
    return this._http.post("http://localhost:8080/auth/signup", body, {
      withCredentials: true
    })
  }

  login(body: { username: string, password: string, remember_me: boolean }) {
    const _body = new URLSearchParams({
      username: body.username,
      password: body.password,
      remember_me: body.remember_me.toString()
    });
    const options = {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded'),
      withCredentials: true
    };
    return this._http.post<Profile>("http://localhost:8080/auth/login", _body.toString(), options)
  }

  user(): Observable<Profile> {
    return this._http.get<Profile>("http://localhost:8080/auth/loggedIn", {withCredentials: true}).pipe(
      map(p => {
        this._profile$.next(p)
        return p;
      }))
  }

  logout() {
    return this._http.post("http://localhost:8080/auth/logout", null, {withCredentials: true});
  }

  ngOnInit(): void {
    this.user().subscribe();
  }
}
