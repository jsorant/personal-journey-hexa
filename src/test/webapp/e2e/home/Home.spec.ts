describe('Home', () => {
  it('display home page', () => {
    cy.visit('/');
    cy.title().should('include', 'Personal Journey');
  });
});
