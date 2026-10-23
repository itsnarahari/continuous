Java Q&A's Pages: https://itsnarahari.github.io/continuous/prep/home.html



Q1–Q6
1. Design a backend API handling 1 million requests per second. How would you design it?

2. Service discovery with auto-scaling: Service A depends on B, C, and D. They auto-scale and their IPs keep changing. Why doesn't your system break?

3. Database performance bottleneck: Your database handles 1 million reads and writes. Both are slow. Scaling is not the answer. How do you fix this?

4. Microservice communication: Two microservices need to communicate. What are your options? How do you decide?

5. Pagination for 1 million records: Your API is returning 1 million records. How do you design pagination?

6. Monolith to microservices migration: Your monolith was fast. You migrated to microservices with the same traffic and performance crashed. What actually broke it?
   Q7–Q12
7. Database sharding hotspot: You sharded your database by User ID for 500 million records. One celebrity joins and one shard gets overloaded. How do you fix it without downtime?

8. Massive traffic spike: 100 million users refresh cricket scores simultaneously. Your database gets 100 million hits in 1 second. How does your system survive?

9. TinyURL duplicate codes: Two users generate a TinyURL at the same time and both get the same short code. How do you prevent this?

10. Autocomplete latency: Your autocomplete API responds in 600 ms. 10 million users are typing simultaneously. How do you fix it?

11. IRCTC Tatkal booking: IRCTC struggles during Tatkal booking at 10 AM while other large platforms handle massive traffic spikes. What is your system missing?

12. Uneven load balancing: You have 10 servers behind a load balancer. One is at 95% CPU while the other 9 are almost idle. Why is traffic so uneven?
    Q13–Q18
13. Cascading failures: Server A crashes and traffic automatically moves to B. B crashes, then another server fails. What could be causing the entire system to fail?

14. Cache outage and database overload: Redis is unavailable for 30 seconds. When it returns, 1 million requests hit the database in 5 seconds. How do you prevent this?

15. Distributed LRU cache: You designed an LRU cache on 3 servers, but users can be routed to different servers randomly. Is your cache still effective?

16. Third-party service failures: Your backend depends on multiple third-party services (payments, email, maps). One of them is slow or down. How do you handle this?

17. Real-time and analytical data: You need to serve both real-time and analytical data at the same time. How would you design the architecture?

18. Global low-latency application: You have a global application with users across the world. Users complain about high latency. How would you design it for low latency globally?
    Q19–Q24
19. File uploads at scale: Your system needs to support file uploads (photos, videos, documents) for millions of users. How would you design it?

20. 100 million emails in one hour: You need to send 100 million notification emails within one hour. How would you design this system?

21. Real-time chat at scale: Your application needs to support real-time chat for millions of users. How would you design it?

22. Search under 100 ms: You have a search feature that must return results in under 100 ms for millions of users. How would you design it?

23. Real-time recommendation system: Your recommendation system needs to handle millions of users with real-time updates. How would you design it?

24. Large report generation: You need to generate reports (large datasets) for millions of users without affecting the main system performance. How would you design it?
    Q25–Q30
25. Activity logs for 1 billion users: Your system stores activity logs for 1 billion users. The data grows rapidly and queries are getting slower. How would you design this?

26. Distributed unique ID generation: You need to generate unique IDs for 1 billion records across multiple servers without a central database. How would you design this?

27. Real-time event processing: Your system needs to process 10 million events per second (clicks, payments, messages) in real time. How would you design it?

28. Multi-region backend: Your backend services are deployed across multiple regions. Users should be able to access the application with low latency from anywhere in the world. How would you design it?

29. Batch jobs at scale: You need to run batch jobs (e.g., generating reports, sending emails) for millions of users without affecting the main application. How would you design this?

30. Read-heavy and write-heavy workloads: Your system handles both read-heavy and write-heavy workloads with unpredictable spikes. How would you design a scalable and reliable architecture?