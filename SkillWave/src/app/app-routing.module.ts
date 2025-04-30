import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoadingComponent } from './loading/loading.component';
import { Sign } from 'crypto';
import { SigninComponent } from './auth/signin/signin.component';
import { SignupComponent } from './auth/signup/signup.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { CardCourseComponent } from './course/card-course/card-course.component';
import { CourseComponent } from './course/course.component';

const routes: Routes = [
  {path:'',component:LoadingComponent},
  {path:'signin',component:SigninComponent},
   {path:'signup',component:SignupComponent}, 
   {path:'courses',component:CourseComponent},
          
  {
    path: '**', component: NotFoundComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
