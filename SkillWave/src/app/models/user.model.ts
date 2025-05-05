export interface User {
  id?: number;
  username?: string;
  fullName?: string;
  email: string;
  password?: string;
  role?: 'STUDENT' | 'INSTRUCTOR' | 'ADMIN';
  avatarUrl?: string;
  bio?: string;
  phone?: string;
}
