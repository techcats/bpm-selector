app.controller('UserData', function($scope, $http) {

	$scope.user = {
		age: '18',
		activity: 'Relaxation'
	};

    $scope.isRelax = function(){
        $scope.user.activity = "Relaxation";
    }
    $scope.isExercise = function(){
        $scope.user.activity = "Exercise";
    }

	
});