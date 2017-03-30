import Ember from 'ember';

export default Ember.Route.extend({
    model() {
        //Beim Öffnen der Anlegen Seite wird ein neues leeres Buch-Objekt erstellt. 
        //Attribute können auf der Seite dann befüllt werden und sind dem Objekt direkt zugeordnet durch Ember-DataBinding
        return this.get('store').createRecord('buch', {
        });
    }
});
