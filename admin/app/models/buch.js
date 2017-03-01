import DS from 'ember-data';

export default DS.Model.extend({

    titel: DS.attr('string'),
    autor: DS.attr('string'),
    verlag: DS.attr('string'),
    isbn: DS.attr('string'),
    auflage: DS.attr('number'),
    erscheinungsjahr: DS.attr('number'),
    kategorie: DS.attr('string')

});
