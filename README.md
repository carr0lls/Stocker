# Stocker
Stocker is a real-time hybrid (web, iOS, Android) application that was created at the [_HACK_A_TON_SF](http://hack-a-ton.com/sf) event sponsored by [Ionic](http://ionicframework.com/), [Firebase](https://www.firebase.com/), [Auth0](https://auth0.com/), and [Socket.io](http://socket.io/) on February 7, 2015. In short, Stocker is a "Tinder" for Stocks. Swipe right to place a bet, swipe left to pass, with real-time data graphs that show the flucation of stocks. The Stocker team consisted of five members including [Carroll Yu](https://www.linkedin.com/in/carrollyu), [Wesley Pascual](https://www.linkedin.com/in/seewes), Antoine Lefebvre, Sébastien Tessot, Jaime Kornick. It was the second place winner of the hackathon.

![example 1](/docs/imgs/ex1.png?raw=true "Example 1")   ![example 2](/docs/imgs/ex2.png?raw=true "Example 2")

### Tools
- [Ionic](http://ionicframework.com/)
- [Cordova](http://cordova.apache.org/)
- [Firebase](https://www.firebase.com/)
- [Auth0](https://auth0.com/)
- [AngularJS](https://angularjs.org/)
- [C3.js](http://c3js.org/)

### Installation
In order to run the project, you need to have `node`, `ionic`, `cordova` and `ios-sim` installed.
Once you have that, just clone the project and run the following:

1. `npm install`
2. `bower install`
3. *  Web: 

      `ionic serve`

    * iOS:

      `ionic platform ios`

      `ionic emulate ios`

    * Android: 

      `ionic platform android`

      `ionic emulate android`
4. (Optional) For real-time data, compile src in "HackatonBack" and run as Java app in Eclipse or any Java IDE.
