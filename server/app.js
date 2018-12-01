const express = require('express');
const app = express();
const morgan = require('morgan');

const foodMenuRouters = require('./api/routers/foodmenu');
const clubsRouters = require('./api/routers/clubs');
const eventsRouters = require('./api/routers/events');

app.use(morgan('dev'));

app.use('/foodmenu', foodMenuRouters);
app.use('/clubs', clubsRouters);
app.use('/events', eventsRouters);

app.use((req, res, next) => {
    const error = new Error('Not found');
    error.status = 404;
    next(error);
});

app.use((error, req, res, next) => {
    res.status(error.status || 500);
    res.json({
        error: {
            message: error.message,
            status: error.status
        }
    });
});

module.exports = app;