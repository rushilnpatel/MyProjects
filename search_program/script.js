
/**
 * Created by Rushil on 5/17/2017.
 */
// Define a new module for our app. The array holds the names of dependencies if any.
var app = angular.module("instantSearch", []);
app.controller('InstantSearchController',function ($scope) {
    $scope.items = [
        {

            title: 'Captain America',
            image: 'captain.jpg',
            release :'2016',
            cast:''
        },
        {

            title: 'Deadpool',
            image: 'deadpool.jpg',
            release :'',
            cast:'2016'
        },
        {

            title: 'The Jungle Book',
            image: 'jungle.jpg',
            release :'2016',
            cast:''
        },
        {

            title: 'Wonder Women',
            image: 'wonder.jpg',
            release :'2017',
            cast:''
        },
        {

            title: 'Baywatch',
            image: 'baywatch.jpg',
            release :'2017',
            cast:''
        },
        {

            title: 'Logan',
            image: 'logan.jpg',
            release :'2017',
            cast:''
        },
        {

            title: 'Kong,Skull Island',
            image: 'king.jpg',
            release :'2017',
            cast:''
        },
        {

            title: 'Furious 7',
            image: 'furious.jpg',
            release :'2015',
            cast:''
        }
    ];


});