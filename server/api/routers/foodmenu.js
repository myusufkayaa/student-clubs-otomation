const express = require('express');
const router = express.Router();

router.get('/', (req, res, next) => {
    res.status(200).json({
        message: 'here is the food menu'
    });
});

router.post('/', (req, res, next) => {
    res.status(201).json({
        message: 'food menu was created!'
    });
});

router.patch('/', (req, res, next) => {
    res.status(200).json({
        message: 'food menu edited!'
    });
});

module.exports = router;