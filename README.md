# Endless Frontier API
[![Build Status](https://travis-ci.org/macgregor/endlessfrontier_api.svg?branch=master)](https://travis-ci.org/macgregor/endlessfrontier_api)

Unofficial Rest API for a mobile game ([Endless Frontier](https://play.google.com/store/apps/details?id=com.ekkorr.endlessfrontier.global&amp;hl=en))

## Tech
* Java 8
* [Gradle](https://macgregor.gitbooks.io/developer-notes/content/software-dev/build_tools/gradle.html)
* [Heroku](https://macgregor.gitbooks.io/developer-notes/content/software-dev/hosting_platforms/heroku.html)
* Travis CI
* Drop Wizard

## Setup
This application produces a standalone jar which contains a Jetty server so it does not need to be deployed to an application server. Simply build and run `java -jar`:

1. `./gradlew build`
2. `java -jar build/output/endlessfrontier-rest-0.0.1/endlessfrontier-rest.jar server`


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


## Planning
### Unanswered Questions
* api documentation
* data storage - small data set that wont grow by much or very quickly. Theres a game update a few times a year that adds a handful of new pets/artifacts. Current dataset is 450k raw, would be surprised if it ever got close to 1M. So some kind of local storage, no need for standalone infrastructure. Research small local, queryable datastores. SQLite?
* authorization - OAuth? Free for all? Decision may be influenced by deployment platform, want to make sure someone cant hammer me into a huge bill. 
