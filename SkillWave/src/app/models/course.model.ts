export interface Course {
    id: number;
    title: string;
    description: string;
    imageUrl?: string;
    price: number;
    instructorId ?: number ;
    category: string;
    createdAt: Date;
    updatedAt: Date;
  }

  
  export const courses: Course[] = [
    {
      id: 1,
      title: "TypeScript Masterclass",
      description: "Complete guide to TypeScript from basics to advanced patterns",
      imageUrl: "https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 59.99,
      instructorId: 101,
      category: "Programming",
      createdAt: new Date("2023-01-10"),
      updatedAt: new Date("2023-06-15")
    },
    {
      id: 2,
      title: "React Native Development",
      description: "Build cross-platform mobile apps with React Native",
      imageUrl: "https://images.unsplash.com/photo-1633356122102-3fe601e05bd2?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 79.99,
      instructorId: 102,
      category: "Mobile Development",
      createdAt: new Date("2023-02-05"),
      updatedAt: new Date("2023-07-10")
    },
    {
      id: 3,
      title: "Python Data Science",
      description: "Data analysis and visualization with Python",
      imageUrl: "https://images.unsplash.com/photo-1551288049-bebda4e38f71?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 89.99,
      instructorId: 103,
      category: "Data Science",
      createdAt: new Date("2023-03-12"),
      updatedAt: new Date("2023-08-18")
    },
    {
      id: 4,
      title: "Digital Marketing Strategy",
      description: "Comprehensive digital marketing course for businesses",
      imageUrl: "https://images.unsplash.com/photo-1551288049-bebda4e38f71?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 69.99,
      instructorId: 104,
      category: "Marketing",
      createdAt: new Date("2023-04-18"),
      updatedAt: new Date("2023-09-22")
    },
    {
      id: 5,
      title: "UX/UI Design Fundamentals",
      description: "Learn user experience and interface design principles",
      imageUrl: "https://images.unsplash.com/photo-1541462608143-67571c6738dd?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 74.99,
      instructorId: 105,
      category: "Design",
      createdAt: new Date("2023-05-22"),
      updatedAt: new Date("2023-10-26")
    },
    {
      id: 6,
      title: "JavaScript Advanced Concepts",
      description: "Deep dive into modern JavaScript patterns",
      imageUrl: "https://images.unsplash.com/photo-1579468118864-1b9ea3c0db4a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 64.99,
      instructorId: 106,
      category: "Programming",
      createdAt: new Date("2023-06-15"),
      updatedAt: new Date("2023-11-19")
    },
    {
      id: 7,
      title: "Financial Planning Essentials",
      description: "Personal finance and investment strategies",
      imageUrl: "https://images.unsplash.com/photo-1554224155-6726b3ff858f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 84.99,
      instructorId: 107,
      category: "Finance",
      createdAt: new Date("2023-07-08"),
      updatedAt: new Date("2023-12-12")
    },
    {
      id: 8,
      title: "Flutter App Development",
      description: "Build beautiful native apps with Flutter",
      imageUrl: "https://images.unsplash.com/photo-1512941937669-90a1b58e7e9c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 79.99,
      instructorId: 108,
      category: "Mobile Development",
      createdAt: new Date("2023-08-20"),
      updatedAt: new Date("2024-01-24")
    },
    {
      id: 9,
      title: "Professional Photography",
      description: "Master your camera and photography techniques",
      imageUrl: "https://images.unsplash.com/photo-1492684223066-81342ee5ff30?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 59.99,
      instructorId: 109,
      category: "Photography",
      createdAt: new Date("2023-09-14"),
      updatedAt: new Date("2024-02-18")
    },
    {
      id: 10,
      title: "Blockchain & Cryptocurrency",
      description: "Understanding blockchain technology and crypto markets",
      imageUrl: "https://images.unsplash.com/photo-1621570072950-694b01d3a889?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 94.99,
      instructorId: 110,
      category: "Technology",
      createdAt: new Date("2023-10-05"),
      updatedAt: new Date("2024-03-10")
    },
    {
      id: 11,
      title: "Node.js Backend Development",
      description: "Build scalable server-side applications with Node.js",
      imageUrl: "https://images.unsplash.com/photo-1563986768609-322da13575f3?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 74.99,
      instructorId: 111,
      category: "Web Development",
      createdAt: new Date("2023-11-12"),
      updatedAt: new Date("2024-04-16")
    },
    {
      id: 12,
      title: "Machine Learning Basics",
      description: "Introduction to ML algorithms and applications",
      imageUrl: "https://images.unsplash.com/photo-1504639725590-34d0984388bd?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 99.99,
      instructorId: 112,
      category: "Data Science",
      createdAt: new Date("2023-12-08"),
      updatedAt: new Date("2024-05-12")
    },
    {
      id: 13,
      title: "Social Media Marketing",
      description: "Strategies for effective social media campaigns",
      imageUrl: "https://images.unsplash.com/photo-1611162616475-46b635cb6868?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 54.99,
      instructorId: 113,
      category: "Marketing",
      createdAt: new Date("2024-01-15"),
      updatedAt: new Date("2024-06-19")
    },
    {
      id: 14,
      title: "Graphic Design Principles",
      description: "Fundamentals of visual communication and design",
      imageUrl: "https://images.unsplash.com/photo-1542744173-8e7e53415bb0?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 64.99,
      instructorId: 114,
      category: "Design",
      createdAt: new Date("2024-02-10"),
      updatedAt: new Date("2024-07-15")
    },
    {
      id: 15,
      title: "Java Programming",
      description: "Object-oriented programming with Java",
      imageUrl: "https://images.unsplash.com/photo-1547658719-da2b51169166?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 69.99,
      instructorId: 115,
      category: "Programming",
      createdAt: new Date("2024-03-05"),
      updatedAt: new Date("2024-08-10")
    },
    {
      id: 16,
      title: "Investment Banking Fundamentals",
      description: "Introduction to investment banking concepts",
      imageUrl: "https://images.unsplash.com/photo-1535320903710-d993d3d77d29?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 89.99,
      instructorId: 116,
      category: "Finance",
      createdAt: new Date("2024-04-18"),
      updatedAt: new Date("2024-09-22")
    },
    {
      id: 17,
      title: "Swift for iOS Development",
      description: "Build iOS apps with Swift programming language",
      imageUrl: "https://images.unsplash.com/photo-1542621334-a254cf47733d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 84.99,
      instructorId: 117,
      category: "Mobile Development",
      createdAt: new Date("2024-05-12"),
      updatedAt: new Date("2024-10-16")
    },
    {
      id: 18,
      title: "Video Editing with Premiere Pro",
      description: "Professional video editing techniques",
      imageUrl: "https://images.unsplash.com/photo-1626785774573-4b799315345d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 74.99,
      instructorId: 118,
      category: "Video Production",
      createdAt: new Date("2024-06-07"),
      updatedAt: new Date("2024-11-11")
    },
    {
      id: 19,
      title: "Cybersecurity Essentials",
      description: "Fundamentals of information security",
      imageUrl: "https://images.unsplash.com/photo-1550751827-4bd374c3f58b?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 99.99,
      instructorId: 119,
      category: "Technology",
      createdAt: new Date("2024-07-22"),
      updatedAt: new Date("2024-12-26")
    },
    {
      id: 20,
      title: "Docker & Kubernetes",
      description: "Containerization and orchestration technologies",
      imageUrl: "https://images.unsplash.com/photo-1625832011745-5d68b8e24979?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 79.99,
      instructorId: 120,
      category: "DevOps",
      createdAt: new Date("2024-08-15"),
      updatedAt: new Date("2025-01-19")
    },
    {
      id: 21,
      title: "Angular Framework Deep Dive",
      description: "Comprehensive Angular development course",
      imageUrl: "https://images.unsplash.com/photo-1633356122544-f134324a6cee?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 69.99,
      instructorId: 121,
      category: "Web Development",
      createdAt: new Date("2024-09-10"),
      updatedAt: new Date("2025-02-14")
    },
    {
      id: 22,
      title: "Big Data with Hadoop",
      description: "Processing large datasets with Hadoop ecosystem",
      imageUrl: "https://images.unsplash.com/photo-1621570321215-0d9a9c6b7b8f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 89.99,
      instructorId: 122,
      category: "Data Science",
      createdAt: new Date("2024-10-05"),
      updatedAt: new Date("2025-03-10")
    },
    {
      id: 23,
      title: "Content Marketing Strategy",
      description: "Creating effective content marketing campaigns",
      imageUrl: "https://images.unsplash.com/photo-1551288049-bebda4e38f71?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 59.99,
      instructorId: 123,
      category: "Marketing",
      createdAt: new Date("2024-11-20"),
      updatedAt: new Date("2025-04-25")
    },
    {
      id: 24,
      title: "3D Modeling with Blender",
      description: "Create 3D assets and animations with Blender",
      imageUrl: "https://images.unsplash.com/photo-1542744173-8e7e53415bb0?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 79.99,
      instructorId: 124,
      category: "3D Design",
      createdAt: new Date("2024-12-15"),
      updatedAt: new Date("2025-05-20")
    },
    {
      id: 25,
      title: "C++ Programming",
      description: "System programming with C++",
      imageUrl: "https://images.unsplash.com/photo-1579468118864-1b9ea3c0db4a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 74.99,
      instructorId: 125,
      category: "Programming",
      createdAt: new Date("2025-01-10"),
      updatedAt: new Date("2025-06-15")
    },
    {
      id: 26,
      title: "Personal Finance Management",
      description: "Strategies for budgeting and financial planning",
      imageUrl: "https://images.unsplash.com/photo-1554224155-6726b3ff858f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 49.99,
      instructorId: 126,
      category: "Finance",
      createdAt: new Date("2025-02-05"),
      updatedAt: new Date("2025-07-10")
    },
    {
      id: 27,
      title: "Android Development with Kotlin",
      description: "Build native Android apps using Kotlin",
      imageUrl: "https://images.unsplash.com/photo-1512941937669-90a1b58e7e9c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 84.99,
      instructorId: 127,
      category: "Mobile Development",
      createdAt: new Date("2025-03-12"),
      updatedAt: new Date("2025-08-17")
    },
    {
      id: 28,
      title: "Motion Graphics with After Effects",
      description: "Create professional motion graphics and animations",
      imageUrl: "https://images.unsplash.com/photo-1492684223066-81342ee5ff30?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 69.99,
      instructorId: 128,
      category: "Video Production",
      createdAt: new Date("2025-04-18"),
      updatedAt: new Date("2025-09-22")
    },
    {
      id: 29,
      title: "Cloud Computing with AWS",
      description: "Introduction to Amazon Web Services",
      imageUrl: "https://images.unsplash.com/photo-1621570072950-694b01d3a889?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 94.99,
      instructorId: 129,
      category: "Cloud Computing",
      createdAt: new Date("2025-05-22"),
      updatedAt: new Date("2025-10-26")
    },
    {
      id: 30,
      title: "Game Development with Unity",
      description: "Create 2D and 3D games using Unity engine",
      imageUrl: "https://images.unsplash.com/photo-1563986768609-322da13575f3?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=800&q=80",
      price: 89.99,
      instructorId: 130,
      category: "Game Development",
      createdAt: new Date("2025-06-15"),
      updatedAt: new Date("2025-11-19")
    }
  ];