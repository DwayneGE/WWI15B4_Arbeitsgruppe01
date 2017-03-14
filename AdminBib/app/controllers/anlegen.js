import Ember from 'ember';
import DS from 'ember-data';

export default Ember.Controller.extend({

    actions : {

        anlegen: function(titel, autor, verlag, isbn, auflage, erscheinungsjahr, kategorie) {
            this.get('store').createRecord('buch', {
                titel: titel,
                autor: autor,
                verlag: verlag,
                isbn: isbn,
                auflage: auflage,
                erscheinungsjahr: erscheinungsjahr,
                kategorie: kategorie
            });
        }
    }
});
