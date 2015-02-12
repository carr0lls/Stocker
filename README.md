# Stocker
Stocker is a real-time hybrid (web, iOS, Android) application that was created at the <a href="http://hack-a-ton.com/sf">_HACK_A_TON_SF</a> event sponsored by <a href="http://ionicframework.com/">Ionic</a>, <a href="https://www.firebase.com/">Firebase</a>, <a href="https://auth0.com/">Auth0</a>, and <a href="http://socket.io/">Socket.io</a> on February 7, 2015. In short, Stocker is a "Tinder" for Stocks. Swipe right to place a bet, swipe left to pass, with real-time data graphs that show the flucation of stocks. The Stocker team consisted of five members including <a href="https://www.linkedin.com/in/carrollyu">Carroll Yu</a>, <a href="https://www.linkedin.com/in/seewes">Wesley Pascual</a>, Antoine Lefebvre, Sébastien Tessot, Jaime Kornick. It was the second place winner of the hackathon.

![example 1](/docs/imgs/ex1.png?raw=true "Example 1")   ![example 2](/docs/imgs/ex2.png?raw=true "Example 2")

<h3>Tools</h3>
- <a href="http://ionicframework.com/">Ionic</a>
- <a href="http://cordova.apache.org/">Cordova</a>
- <a href="https://www.firebase.com/">Firebase</a>
- <a href="https://auth0.com/">Auth0</a>
- <a href="https://angularjs.org/">AngularJS</a>
- <a href="http://c3js.org/">C3.js</a>

<h3>Installation</h3>
In order to run the project, you need to have `node`, `ionic`, `cordova` and `ios-sim` installed.
Once you have that, just clone the project and run the following:

1. `npm install`
2. `bower install`
3. 
    Web: 
    `ionic serve`
    iOS:
    `ionic platform ios`
    `ionic emulate ios`
    Android: 
    `ionic platform android`
    `ionic emulate android`
4. (Optional) For real-time data, compile src in "HackatonBack" and run as Java app in Eclipse or any Java IDE.
