//find the publicpath of output. where does the website direct to?

const path = require("path");

module.exports = {
    entry: {
        'app':  path.resolve(__dirname, "src/main/webapp/js/app.js"),
        'index': path.resolve(__dirname, "src/main/webapp/js/index.js"),
        'login': path.resolve(__dirname, "src/main/webapp/js/login.js")
    },
    module: {
        rules: [


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