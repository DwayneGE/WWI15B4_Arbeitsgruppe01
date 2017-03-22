import Ember from 'ember';
import DS from 'ember-data';

export default Ember.Controller.extend({
    actions:{
        save(buchRecord){
            console.log(buchRecord);
            buchRecord.save()
            .then(()=> console.log('erfolg'))
            .catch(()=>console.log('ein fehler'));
            this.transitionToRoute("bearbeiten");
        }
    }
});
