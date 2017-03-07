import Ember from 'ember';

export default Ember.Controller.extend({

    actions : {

        anlegen: function(titel, autor, verlag, isbn, auflage, erscheinungsjahr, kategorie) {
            store.createRecord('buch', {
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
