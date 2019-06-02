#Code challange interview
==================================

### Post blog App <br/>
<img src ="https://github.com/douglasalipio/android_posts_list/blob/coroutines/app/images/comment_screen.jpg"  width="360"/>&nbsp;&nbsp;
<img src ="https://github.com/douglasalipio/android_posts_list/blob/coroutines/app/images/post_detail_screen.jpg" width="360" />&nbsp;&nbsp;
<img src ="https://github.com/douglasalipio/android_posts_list/blob/coroutines/app/images/post_screen.jpg"  width="360"/>

### Features

Fetching all required data from the folowing API endpoints:

- GET http://jsonplaceholder.typicode.com/posts
- GET http://jsonplaceholder.typicode.com/users 
- GET http://jsonplaceholder.typicode.com/comments

Fetching data from randomuser.me to get avatars for the authors.

- GET https://randomuser.me/api/?inc=picture&results=10

### Project architecture

I have implemented MVP architecture for the project with interactors. It is responsible for the same responsibilities as the DataManager but it is only concerned with those data access and processing calls that are required by the feature that it is serving.

### Relevant 3rd party libraries

- Retrofit2
- Coroutines
- Dagger2
- Picasso
- Espresso
- Mockito
- Junit4

### Focus on architecture or UI. Which one you prefer of the 2 options and why?
I prefer to spend more efforts developing activities related to the architecture of the project because I had professional experiences in the area and because I like studying this field in my free time subjects related to design patterns, how to keep the code clean, refactoring of legacy projects, bug fixes and so on.
