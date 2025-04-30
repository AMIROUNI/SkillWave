import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private httpClinet:HttpClient) { }

  private baseUrl = 'http://localhost:8095/api/courses'; // Adjust the URL as needed

  getAllCourses() {
    return this.httpClinet.get(this.baseUrl);
  }


  getCourseById(id: number) {
    return this.httpClinet.get(`${this.baseUrl}/${id}`);
  }
  

  createCourse(course: any) {
    return this.httpClinet.post(this.baseUrl, course);
  }

  updateCourse(id: number, course: any) {
    return this.httpClinet.put(`${this.baseUrl}/${id}`, course);
  }
  deleteCourse(id: number) {
    return this.httpClinet.delete(`${this.baseUrl}/${id}`);
  }



}
