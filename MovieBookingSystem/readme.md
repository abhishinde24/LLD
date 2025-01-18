# MovieTicket Management System

[problem statement](https://github.com/ashishps1/awesome-low-level-design/blob/main/problems/movie-ticket-booking-system.md)
## Requirements
- The system should allow users to view the list of movies playing in different theaters.
- Users should be able to select a movie, theater, and show timing to book tickets.
- The system should display the seating arrangement of the selected show and allow users to choose seats.
- Users should be able to make payments and confirm their booking.
- The system should handle concurrent bookings and ensure seat availability is updated in real-time.
- The system should support different types of seats (e.g., normal, premium) and pricing.
- The system should allow theater administrators to add, update, and remove movies, shows, and seating arrangements.
- The system should be scalable to handle a large number of concurrent users and bookings.

## Before starting with defining class I would like to have clearifying some questions
1. While displaying current running movies in theater we should do support which kind of filter?
- Currently listing down the shows
2. What would be seating arrangement?
- It would be different for each theater, but for current usecase we can having same arrangement like n * n square, with 50% premium seats and 50% normal seats 

## Defining some strategy for critical features
1. How would I handle concurrency?
- We can have some kind of lock while booking, a booking process will be thread if we break out of thread lock will get released

High-Level class 
- user
- movie
- theater
- show
- seat
- booking

# Need to do
- Change locking strategy
- Implement Advance search capabilities.

Resource
- Nice tutorial for locking https://github.com/anomaly2104/ticket-booking-low-level-system-design/blob/master/src/main/java/com/uditagarwal/providers/InMemorySeatLockProvider.java