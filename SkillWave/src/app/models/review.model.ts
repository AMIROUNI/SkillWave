export interface Review {
    id: number;
    courseId: number;
    studentId: number;
    rating: number; // example: 1 to 5
    comment?: string;
    createdAt: Date;
  }
  