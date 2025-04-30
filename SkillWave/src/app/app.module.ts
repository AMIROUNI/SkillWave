import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoadingComponent } from './loading/loading.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NextLoadingComponent } from './loading/next-loading/next-loading.component';
import { SignupComponent } from './auth/signup/signup.component';
import { SigninComponent } from './auth/signin/signin.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SanitizeUrlPipe } from './pipes/sanitize-url.pipe';
import { NotFoundComponent } from './not-found/not-found.component';
import { CardCourseComponent } from './course/card-course/card-course.component';
import { CourseComponent } from './course/course.component';

@NgModule({
  declarations: [
    AppComponent,
    LoadingComponent,
    HeaderComponent,
    FooterComponent,
    NextLoadingComponent,
    SignupComponent,
    SigninComponent,
    NotFoundComponent,
    CardCourseComponent,
    CourseComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    SanitizeUrlPipe
],
  providers: [
    provideClientHydration(withEventReplay())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
