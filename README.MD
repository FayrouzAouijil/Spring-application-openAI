# Backend Engineering - Internship 

A springboot java application to communicate with ChatGPT AI via a call to an endpoint.

## Steps to Setup

**1. Clone the application (VS CODE)**

```bash
https://github.com/FayrouzAouijil/Spring-application-openAI.git
```

**2. Install extentions**
```bash
Extension Pack for Java
Spring Boot Extension Pack
```

**3. Build and run the app**

+ open `src/main/java/DemoApplication.java`

+ run the application from the icon in the top right 

The app will start running at <http://localhost:8080>.

You can put your question in the text field exposed in the home page then click the button or press 'ENTER'.

Every question and answer will be saved in your Document folder on the name 'History'.

## Explore Rest API

The app defines following API.
    
    POST https://api.openai.com/v1/completions