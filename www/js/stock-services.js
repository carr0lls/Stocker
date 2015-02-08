angular.module('stock.services', ['firebase'])

/**
 * A simple example service that returns some data.
 */
.service('StockService', function($firebase, store, $state) {

  var stocksRef = new Firebase("https://glaring-inferno-4364.firebaseio.com/stocks");
      stocksRef.authWithCustomToken(store.get('firebaseToken'), function(error, auth) {
    if (error) {
      // There was an error logging in, redirect the user to login page
      $state.go('login');
    }
  });

  var stocksSync = $firebase(stocksRef);
  var stocks = stocksSync.$asArray();

  this.all = function() {
    return stocks;
  };

  this.add = function(stock) {
    stocks.$add(stock);
  };

  this.get = function(id) {
    return stocks.$getRecord(id);
  };

  this.save = function(stock) {
    stocks.$save(stock);
  };

  this.delete = function(stock) {
    stocks.$remove(stock);
  };

})
    .service('BetService', function($firebase, store, $state) {

      var betsRef = new Firebase("https://glaring-inferno-4364.firebaseio.com/bets");
      betsRef.authWithCustomToken(store.get('firebaseToken'), function(error, auth) {
        if (error) {
          // There was an error logging in, redirect the user to login page
          $state.go('login');
        }
      });

      var betsSync = $firebase(betsRef);
      var bets = betsSync.$asArray();

      this.all = function() {
        return bets;
      };

      this.add = function(bet) {
        bets.$add(bet);
      };

      this.get = function(id) {
        return bets.$getRecord(id);
      };

      this.save = function(bet) {
        bets.$save(bet);
      };

      this.delete = function(bet) {
        bets.$remove(stock);
      };

    })


;


