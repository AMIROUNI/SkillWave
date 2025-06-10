export interface User {
  id?: number;
  name?: string;
  fullName?: string;
  email: string;
  password?: string;
  role?: 'STUDENT' | 'INSTRUCTOR' | 'ADMIN';
  avatarUrl?: string;
  bio?: string;
  phone?: string;
}
