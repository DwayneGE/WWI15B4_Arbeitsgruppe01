import Ember from 'ember';

export default Ember.Route.extend({
model() {
    //GET Request um alle Bücher aus der Datenbank zu holen
    return this.get('store').findAll('buch');
    }
});
