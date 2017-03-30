import Ember from 'ember';

export default Ember.Controller.extend({

    actions:{
        //PATCH Request um die geänderten Attribute am Buch an die API zu senden
        save(buchRecord){
            console.log(buchRecord);
            buchRecord.save()
            .then(()=> console.log('erfolg'))
            .catch(()=>console.log('ein fehler'));
            this.transitionToRoute("buch.bearbeiten");
        }
    }
});
