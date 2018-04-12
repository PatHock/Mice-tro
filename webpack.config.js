//find the publicpath of output. where does the website direct to?

const path = require("path");

module.exports = {
    entry: {
        'app':  path.resolve(__dirname, "src/main/webapp/js/app.js")
    },
    module: {
        rules: [
            { test: /\.js$/, exclude: /node_modules/, loader: "babel-loader" }
        ]
    },
    output: {
        filename: '[name].bundle.js',
        path: path.resolve(__dirname, "src/main/webapp/js/dist"),
        publicPath: '/micetr0/webpack/dist'
    }
};