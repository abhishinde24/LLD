# ZipReel: Movie Content Management System

## Problem Statement
We are building **ZipReel**, a movie content management system for a streaming platform. The system allows users to:
- Register movies and users.
- Search movie information efficiently using a multi-level caching mechanism.
- Handle frequent searches with optimized retrieval for lightning-fast results.

---

## Multi-Level Cache Explanation

### What is a Multi-Level Cache?
1. **L1 Cache (User-Specific Cache):**
    - Stores the 5 most recent searches for each user.
    - Implements **LRU (Least Recently Used)** eviction policy.

2. **L2 Cache (Global Popular Cache):**
    - Stores the 20 most popular searches globally.
    - Implements **LFU (Least Frequently Used)** eviction policy.

3. **Primary Store:**
    - Contains the complete movie database stored in memory.

---

### Cache Hit vs. Cache Miss
- **Cache Hit:**  
  Data is found in one of the cache levels (L1 or L2).
- **Cache Miss:**  
  Data is not found in caches and must be retrieved from the primary store.

---

## System Requirements
### Functional Features
1. **Add Movies:**
    - Each movie has the following attributes:
        - `Movie ID` (unique)
        - `Title`
        - `Genre`
        - `Release Year`
        - `Rating`

2. **Register Users:**
    - Each user has the following attributes:
        - `User ID` (unique)
        - `Name`
        - `Preferred Genre`

3. **Implement Multi-Level Caching:**
    - **L1 Cache:** User-specific, max 5 entries per user, uses LRU eviction.
    - **L2 Cache:** Global popular cache, max 20 entries, uses LFU eviction.
    - **Primary Store:** Complete in-memory movie database.

4. **Search Operations:**
    - Search by:
        - `Title`
        - `Genre`
        - `Release Year`
        - Multiple filter combinations (genre, year, rating).
    - Search process:
        1. Check L1 cache.
        2. If not found, check L2 cache.
        3. If still not found, search in the primary store.
        4. Update caches based on search results.

5. **Bonus Feature:**
    - View cache-level statistics (hits and total searches).

---

## Supported Commands
1. **Add a Movie:**
   ```plaintext
   ADD_MOVIE <id> <title> <genre> <year> <rating>

Example: `ADD_MOVIE 1 "Inception" "Sci-Fi" 2010 9.5`

2. **Add User**
    ```plaintext
   ADD_USER <id> <name> <preferred_genre>

Example: `ADD_USER 1 "John" "Action"`

3. **Search**
    ```plaintext
   SEARCH <user_id> <search_type> <search_value> 

Example: `SEARCH 1 GENRE "Action"`

4. **Multi-Filter Search**
    ```plaintext
   SEARCH_MULTI <user_id> <genre> <year> <min_rating>

Example: `SEARCH_MULTI 1 "Action" 2020 8.0`

5. **View Cache Statistics**
    ```plaintext
   VIEW_CACHE_STATS

6. **Clear Cache**
    ```plaintext
   CLEAR_CACHE <cache_level>
Output : 
```
L1 Cache Hits: X
L2 Cache Hits: Y
Primary Store Hits: Z
Total Searches: N
```
Example: `CLEAR_CACHE L1`

## Search Capabilities
- Search by title
- Search by genre
- Search by release year
- Multiple filter combinations

## Bonus Feature
- Cache hit tracking for L1, L2, and Primary Store
- Total system search count display

## Development Guidelines

### Technical Constraints
- In-memory data structures only
- No external databases
- No API or UI implementation

### Implementation Expectations
- Modular and object-oriented design
- Proper exception handling
- Efficient cache eviction policies
- Clear separation of concerns

## Architectural Components
- Data Storage
- Cache Management
- Search Operations

## Potential Challenges
- Implementing multi-level cache
- Handling different search types
- Efficient cache eviction strategies