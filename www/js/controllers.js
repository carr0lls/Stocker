angular.module('starter.controllers', ['ionic', 'ionic.contrib.ui.tinderCards'])

.controller('LoginCtrl', function($scope, auth, $state, store) {
  auth.signin({
    closable: false,
    // This asks for the refresh token
    // So that the user never has to log in again
    authParams: {
      scope: 'openid offline_access'
    }
  }, function(profile, idToken, accessToken, state, refreshToken) {
    store.set('profile', profile);
    store.set('token', idToken);
    store.set('refreshToken', refreshToken);
    auth.getToken({
      api: 'firebase'
    }).then(function(delegation) {
      store.set('firebaseToken', delegation.id_token);
      $state.go('tab.friends');
    }, function(error) {
      console.log("There was an error logging in", error);
    })
  }, function(error) {
    console.log("There was an error logging in", error);
  });
})


.controller('FriendsCtrl', function($scope, Friends, $ionicModal) {
 $ionicModal.fromTemplateUrl('templates/friend-add-modal.html', {
    scope: $scope,
    animation: 'slide-in-up'
  }).then(function(modal) {
    $scope.modal = modal;
  });

  $scope.newFriend = {
    name: '',
    description: ''
  };

  $scope.friends = Friends.all();

  $scope.showAddFriend = function() {
    $scope.modal.show();
  };

  $scope.addFriend = function() {
    if(!$scope.newFriend.$id) {
      Friends.add($scope.newFriend);
    } else {
      Friends.save($scope.newFriend);
    }
    $scope.newFriend = {};
    $scope.modal.hide();
  };

  $scope.deleteFriend = function(friend) {
    Friends.delete(friend);
  };

  $scope.editFriend = function(friend) {
    $scope.newFriend = friend;
    $scope.modal.show();
  };

  $scope.close = function() {
    $scope.modal.hide();
  };

  $scope.$on('$destroy', function() {
    $scope.modal.remove();
  });
})

.controller('FriendDetailCtrl', function($scope, $stateParams, Friends) {
  $scope.friend = Friends.get($stateParams.friendId);
})

.controller('AccountCtrl', function($scope, auth, $state, store) {

  $scope.logout = function() {
    auth.signout();
    store.remove('token');
    store.remove('profile');
    store.remove('refreshToken');
    $state.go('login');
  }
})

// Tinder Cards

.directive('noScroll', function() {

  return {
    restrict: 'A',
    link: function($scope, $element, $attr) {

      $element.on('touchmove', function(e) {
        e.preventDefault();
      });
    }
  }
})
.controller('StockController', function($scope, StockService) {

    $scope.stocks = StockService.all();

})

.controller('StockDetailController', function($scope, $stateParams, StockService) {
    $scope.stock = StockService.get($stateParams.stockId);
})
.controller('CardsCtrl', function($scope, TDCardDelegate, StockService) {


    $scope.cards = StockService.all();


        var cardTypes = [
    { image: 'img/max.jpg' },
    { image: 'img/ben.png' },
    { image: 'img/perry.jpg' },
    { image: 'img/ionic.png' }
  ];

  $scope.cardDestroyed = function(index) {
    $scope.cards.splice(index, 1);
  };

  $scope.addCard = function() {
    var newCard = cardTypes[Math.floor(Math.random() * cardTypes.length)];
    newCard.id = Math.random();
    $scope.cards.unshift(angular.extend({}, newCard));
  }

  $scope.cards = [];
  for(var i = 0; i < 3; i++) $scope.addCard();
})

.controller('CardCtrl', function($scope, TDCardDelegate) {
  $scope.cardSwipedLeft = function(index) {
    console.log('LEFT SWIPE');
    $scope.addCard();
  };

  $scope.cardSwipedRight = function(index) {
    console.log('RIGHT SWIPE');
    $scope.addCard();
  };
})

    .controller('StockDetailController', function($scope, $stateParams, StockService) {
        $scope.stock = StockService.get($stateParams.stockId);
    })
    .controller('CardsCtrl', function($scope, TDCardDelegate, StockService) {


        $scope.cards = StockService.all();


        var cardTypes = [
            { image: 'img/max.jpg' },
            { image: 'img/ben.png' },
            { image: 'img/perry.jpg' },
            { image: 'img/ionic.png' }
        ];

        $scope.cardDestroyed = function(index) {
            $scope.cards.splice(index, 1);
        };

        $scope.addCard = function() {
            var newCard = cardTypes[Math.floor(Math.random() * cardTypes.length)];
            newCard.id = Math.random();
            $scope.cards.unshift(angular.extend({}, newCard));
        }

        $scope.cards = [];
        for(var i = 0; i < 3; i++) $scope.addCard();
    })

    .controller('CardCtrl', function($scope, TDCardDelegate) {
        $scope.cardSwipedLeft = function(index) {
            console.log('LEFT SWIPE');
            $scope.addCard();
        };

        $scope.cardSwipedRight = function(index) {
            console.log('RIGHT SWIPE');
            $scope.addCard();
        };
    })

    .controller('StockCardsCtrl', function($scope, TDCardDelegate, StockService) {


        $scope.cards = StockService.all();

        $scope.cardDestroyed = function(index) {
            $scope.cards.splice(index, 1);
        };
    
    })

    .controller('StockCardCtrl', function($scope, TDCardDelegate) {
        $scope.cardSwipedLeft = function(index) {
            console.log('LEFT SWIPE');
            $scope.addCard();
        };

        $scope.cardSwipedRight = function(index) {
            console.log('RIGHT SWIPE');
            $scope.addCard();
        };
    })
;
