const express = require('express');
const router = express.Router();

router.get('/', (req, res, next) => {
    res.status(200).json({
        message: 'all list of the student clubs'
    });
});

router.post('/', (req, res, next) => {
    res.status(201).json({
        message: 'new student club was created'
    });
});

router.get('/:clubId', (req, res, next) => {
    const id = req.params.clubId;
    if (id === 'yna'){
        res.status(200).json({
            message: 'Here we are, the YNA!',
            id: id
        });
    } else {
        res.status(200).json({
            message: 'it is just eh!'
        });
    }
});

router.patch('/:clubId', (req, res, next) => {
    const id = req.params.clubId;
    res.status(200).json({
        message: 'club infos updared!',
        id: id
    });
});

router.delete('/:clubId', (req, res, next) => {
    const id = req.params.clubId;
    res.status(200).json({
        message: 'club deleted!',
        id: id
    });
});

module.exports = router;