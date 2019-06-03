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

I have implemented MVP architecture for the project with interactors. It is responsible for the same responsibilities as the DataManager. However, it is only concerned with data access and processing calls that are required by the feature that it is serving.

### Relevant 3rd party libraries

- Retrofit2
- Coroutines
- Dagger2
- Picasso
- Espresso
- Mockito
- Junit4

### Focus on architecture or UI. Which one you prefer of the two options and why?
I have professional experience developing activities related to project architectures. Consequently, in most cases, I prefer to spend more efforts on the architectural area. In my free time, I also like studying subjects and best practices in this field, for instance, design patterns, how to keep the code clean, refactoring legacy projects, bug fixes, and so on.
