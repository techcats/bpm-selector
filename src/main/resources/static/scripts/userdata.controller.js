app.controller('UserData', function($scope, $http, $mdDialog, $location) {

    var queryParams = $location.search();

	$scope.user = {
	    hashId: queryParams.userid,
		age: '',
		activity: 'Relaxation',
		gender: 'female'
	};

    $scope.isRelax = function(){
        $scope.user.activity = "Relaxation";
        if(!angular.isNumber($scope.user.age) || $scope.user.age < 1 || $scope.user.age > 999){
                $mdDialog.show(
                  $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Uh Oh. Something went wrong')
                    .textContent('Probably your age...fix it!')
                    .ariaLabel('dialog alert')
                    .ok('Got it!')
                );
        }else{
            $scope.user.age = Math.max(1, Math.floor($scope.user.age));
            $scope.sendJSON();
            $scope.getTracks();
        }
    }
    $scope.isExercise = function(){
        $scope.user.activity = "Exercise";

        if(!angular.isNumber($scope.user.age) || $scope.user.age < 1 || $scope.user.age > 999){
                $mdDialog.show(
                  $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Uh Oh. Something went wrong')
                    .textContent('Probably your age...fix it!')
                    .ariaLabel('dialog alert')
                    .ok('Got it!')
                );
        }else{
            $scope.user.age = Math.max(1, Math.floor($scope.user.age));
            $scope.sendJSON();
            $scope.getTracks();
        }
    }

    $scope.fitbitLogin = function() {

        window.location.href = "/GrantFitbitAuthorization";
    }

    $scope.sendJSON = function(){
    		var dataObj = {
    				age : $scope.user.age,
    				activity : $scope.user.activity,
    				gender : $scope.user.gender,
    		};
            var res = $http.put('/users/' + queryParams.userid, dataObj)
            		.then(function(data, status, headers, config) {
            			$scope.message = data;
            		});
    };

//    var queryParams = $location.search();


    $scope.isLoggedIn = typeof(queryParams.token) !== 'undefined' && queryParams.token !== '';

    $scope.spotifylogin = function(){
        window.location.href = "/spotify/login?userid=" + queryParams.userid;
    };

    $scope.getTracks = function(){

        $http.get('/spotify/tracks' + '?userid=' + queryParams.userid + '&token=' + queryParams.token + '&limit=10&offset=0')
            .then(function(response){
                $scope.tracks = response.data;
            });
    };

});

