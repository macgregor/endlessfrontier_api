# Endless Frontier API
[![Build Status](https://travis-ci.org/macgregor/endlessfrontier_api.svg?branch=master)](https://travis-ci.org/macgregor/endlessfrontier_api)

Unofficial Rest API for a mobile game ([Endless Frontier](https://play.google.com/store/apps/details?id=com.ekkorr.endlessfrontier.global&amp;hl=en))

[Rest API Documentation](https://macgregor.github.io/endlessfrontier_api/)

## Tech
* Java 8
* [Gradle](https://macgregor.gitbooks.io/developer-notes/content/software-dev/build_tools/gradle.html)
* [Heroku](https://macgregor.gitbooks.io/developer-notes/content/software-dev/hosting_platforms/heroku.html)
* Travis CI
* Drop Wizard

## Setup
This application produces a standalone jar which contains a Jetty server so it does not need to be deployed to an application server. Simply build and run `java -jar`:

1. `./gradlew build`
2. `java -jar build/endlessfrontier-api.jar server src/main/resources/config.yml`


## API Documentation
Swagger is used to automatically generate API documentation, unfortunately it isnt completely automated yet since part of the process requires having an npn application installed. Once that is installed, however, generating the documentation is simple.

1. `npm install -g spectacle-docs`
2. `./gradleq generateDocs`

This relies on the [swagger gradle plugin](https://github.com/gigaSproule/swagger-gradle-plugin) to generate swagger.json, the swagger documentation specification file. Next I use a command line tool called [spectacle](https://github.com/sourcey/spectacle) to turn swagger.json into a decent looking html web site. This can then be deployed wherever. I have this repositories Github Pages set up to host it, you just add the push the files.

## Heroku
If you have never worked with Heroku before their [getting started guide](https://devcenter.heroku.com/articles/getting-started-with-java#introduction) is a good crash course.


### New Deployment
1. [install heroku cli](https://devcenter.heroku.com/articles/heroku-cli)
2. `heroku login`
3. `heroku create` (from root of git repo)

This will create a new application on your Heroku account and add a new git remote called heroku which you can push code to to deploy. You can also configure [github integration](https://devcenter.heroku.com/articles/github-integration) to automatically deploy new versions of the app when you push to github.


### Deploy To Heroku
From the root directory of the git repo:

1. `git push heroku master`
2. `heroku ps:scale web=1`
3. `heroku open` or visit https://{appname}.herokuapp.com
4. `heroku logs --tail`


### Deploy Locally
1. `./gradlew build`
2. `heroku local`
3. visit localhost:$PORT, make note of the port in the server logs. Mine always picks 5000 but that number could change.