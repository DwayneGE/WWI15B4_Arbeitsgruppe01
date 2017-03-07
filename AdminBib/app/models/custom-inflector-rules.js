import Inflector from 'ember-inflector';

const inflector = Inflector.inflector;

//inflector.irregular('buch', 'buches');
inflector.uncountable('buch');

// Meet Ember Inspector's expectation of an export
export default {};