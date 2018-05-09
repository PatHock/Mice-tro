//find the publicpath of output. where does the website direct to?

const path = require("path");

module.exports = {
    entry: {
        'index': path.resolve(__dirname, "src/main/webapp/js/index.js"),
        'login': path.resolve(__dirname, "src/main/webapp/js/login.js"),
        'profile': path.resolve(__dirname, "src/main/webapp/js/profile.js"),
        'composition': path.resolve(__dirname, "src/main/webapp/js/composition.js"),
        'createComposition': path.resolve(__dirname, "src/main/webapp/js/createComposition.js"),
        'whoops': path.resolve(__dirname, "src/main/webapp/js/whoops.js")
    },
    module: {
        rules: [

            // Use commented out code when switching to sass

            // {
            //     test: /\.(scss)$/,
            //     use: [{
            //         loader: 'style-loader', // inject CSS to page
            //     }, {
            //         loader: 'css-loader', // translates CSS into CommonJS modules
            //     }, {
            //         loader: 'postcss-loader', // Run post css actions
            //         options: {
            //             plugins: function () { // post css plugins, can be exported to postcss.config.js
            //                 return [
            //                     require('precss'),
            //                     require('autoprefixer')
            //                 ];
            //             }
            //         }
            //     }, {
            //         loader: 'sass-loader' // compiles Sass to CSS
            //     }]
            // },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            },


            { test: /\.js$/, exclude: /node_modules/, loader: "babel-loader" }
            // { test: /\.scss$/, exclude: /node_modules/, loader: "sass-loader"},
            // { test: /\.sass$/, exclude: /node_modules/, loader: "sass-loader"},
        ]
    },
    output: {
        filename: '[name].bundle.js',
        path: path.resolve(__dirname, "src/main/webapp/js/dist"),
        publicPath: '/micetr0/js/dist'
    }
};