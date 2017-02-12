app.controller('UserData', function($scope, $http, $mdDialog) {

	$scope.user = {
		age: '',
		activity: 'Relaxation'
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
        }
    }

    $scope.fitbitLogin = function() {

        window.location.href = "/GrantFitbitAuthorization";
    }

    $scope.sendJSON = function(){
    		var dataObj = {
    				age : $scope.user.age,
    				activity : $scope.user.activity,
    		};
            var res = $http.put('/users/1', dataObj)
            		.then(function(data, status, headers, config) {
            			$scope.message = data;
            		});
            		// Making the fields empty
            		//
            		$scope.age='';
            		$scope.activity='';
    };
});

