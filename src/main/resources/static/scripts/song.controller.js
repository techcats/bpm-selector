app.controller('SongData', function($scope, $http) {

    $scope.songlist=[
        {name:"Drake", song:"Too Good", bpm:"117.98", genre:"pop"},
        {name:"Glantis", song:"No Money", bpm:"126.01", genre:"electro"},
        {name:"Kungs", song:"This Girl", bpm:"121.97", genre:"r&b"},
        {name:"DNCE", song:"Cake By The Ocean", bpm:"119.01", genre:"pop"},
        {name:"Lukas Graham", song:"7 Years", bpm:"119.99", genre:"electro"},
        {name:"Selena Gomez", song:"Kill Em With Kindness", bpm:"120.02", genre:"pop"},
        {name:"Flume", song:"Never Be Like You", bpm:"119.25", genre:"pop"},
        {name:"Jonas Blue", song:"TPerfect Strangers", bpm:"117.98", genre:"electro"},
        {name:"ZAYN", song:"PILLOWTALK", bpm:"124.98", genre:"pop"},
        {name:"Jason Derulo", song:"If It Ain't Love", bpm:"128.98", genre:"r&b"},
        {name:"Jennifer Lopez", song:"Ain't Your Mama", bpm:"120.98", genre:"pop"}
    ];

    $scope.spotifylogin = function(){
        window.location.href = "/spotify/login";
    };
});