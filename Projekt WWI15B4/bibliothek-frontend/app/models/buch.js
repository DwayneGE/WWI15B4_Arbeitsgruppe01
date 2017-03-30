import DS from 'ember-data';

export default DS.Model.extend({
    //Model mit den Attributen der Bücher
    titel: DS.attr(),
    autor: DS.attr(),
    verlag: DS.attr(),
    isbn: DS.attr(),
    auflage: DS.attr(),
    erscheinungsjahr: DS.attr(),
    kategorie: DS.attr()
});
