import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from "./views/home/home.component";
import {AuthGuard} from "./views/auth/guards/auth.guard";

const routes: Routes = [
  {
    path: 'auth', loadChildren: () => import("src/app/views/auth/auth.module").then(m => m.AuthModule)
  },
  {
    path: '', component: HomeComponent, canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
