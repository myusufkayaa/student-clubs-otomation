const express = require('express');
const router = express.Router();

router.get('/', (req, res, next) => {
    res.status(200).json({
        message: 'all list of the events'
    });
});

router.post('/', (req, res, next) => {
    res.status(201).json({
        message: 'new event was created'
    });
});

router.get('/:eventId', (req, res, next) => {
    const id = req.params.eventId;
    res.status(200).json({
        message: 'event is here!',
        id: id
    });
});

router.patch('/:eventId', (req, res, next) => {
    const id = req.params.eventId;
    res.status(200).json({
        message: 'event infos updared!',
        id: id
    });
});

router.delete('/:eventId', (req, res, next) => {
    const id = req.params.eventId;
    res.status(200).json({
        message: 'eventId deleted!',
        id: id
    });
});

module.exports = router;