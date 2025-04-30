export interface User {
   
    username?: string;
    email: string;
    password?: string; // Optional when fetching
    role?: 'STUDENT' | 'INSTRUCTOR' | 'ADMIN';
    avatarUrl?: string;
    bio?: string;
  }
  