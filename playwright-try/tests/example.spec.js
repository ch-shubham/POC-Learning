// @ts-nocheck
const { test, expect } = require("@playwright/test");

// test('has title', async ({ page }) => {
//   await page.goto('https://playwright.dev/');

//   // Expect a title "to contain" a substring.
//   await expect(page).toHaveTitle(/Playwright/);
// });

// test('get started link', async ({ page }) => {
//   await page.goto('https://playwright.dev/');

//   // Click the get started link.
//   await page.getByRole('link', { name: 'Get started' }).click();

//   // Expects page to have a heading with the name of Installation.
//   await expect(page.getByRole('heading', { name: 'Installation' })).toBeVisible();
// });

test("copy data", async ({ page }) => {
  console.log("Try1");
  try {
    await page.goto("https://jamesclear.com/five-step-creative-process");
    await expect(page).toHaveTitle(/Creative/);
    const contentElement = await page.$(".page__content");
    const loremIpsumText = await contentElement.innerText();
    console.log(loremIpsumText);
  } catch (err) {
    console.log("ERR", err);
  }
});
