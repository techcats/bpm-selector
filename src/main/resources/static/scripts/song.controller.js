app.controller('SongData', function($scope, $http, $location) {

    var queryParams = $location.search();


    $scope.isLoggedIn = typeof(queryParams.token) !== 'undefined' && queryParams.token !== '';

    $scope.spotifylogin = function(){
        window.location.href = "/spotify/login?userid=" + queryParams.userid;
        $scope.getTracks();
    };

    $scope.getTracks = function(){

        $http.get('/spotify/tracks' + '?userid=' + queryParams.userid + '&token=' + queryParams.token)
            .then(function(response){
                $scope.tracks = response.data;
            });
    };


});