//find the publicpath of output. where does the website direct to?

const path = require("path");

module.exports = {
    entry: {
        'app':  path.resolve(__dirname, "src/main/webapp/js/app.js")
    },
    module: {
        rules: [
            { test: /\.js$/, exclude: /node_modules/, loader: "babel-loader" },
            { test: /\.scss$/, exclude: /node_modules/, loader: "sass-loader"},
            { test: /\.sass$/, exclude: /node_modules/, loader: "sass-loader"},
        ]
    },
    output: {
        filename: '[name].bundle.js',
        path: path.resolve(__dirname, "src/main/webapp/js/dist"),
        publicPath: '/micetr0/js/dist'
    }
};