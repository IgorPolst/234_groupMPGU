import pixelmatch from 'pixelmatch';
import sharp from 'sharp';
import fs from 'fs';
import path from 'path';
import { test, expect } from '@playwright/test';

let num = 0;
test.describe('Drawing App Tests', () => {

    test.beforeEach(async ({ page }) => {
        await page.goto('http://127.0.0.1:5500/10_lection/lab9/e2e/public/index.html');
    });

    test('should load the app and display controls', async ({ page }) => {
        await expect(page.locator('#toolSelect')).toBeVisible();
        await expect(page.locator('#thicknessSlider')).toBeVisible();
        await expect(page.locator('#colorPicker')).toBeVisible();
        await expect(page.locator('#clearCanvas')).toBeVisible();
        await expect(page.locator('#saveDrawing')).toBeVisible();
    });

    test('should allow drawing with the pen tool', async ({ page }) => {
        const canvas = await page.locator('canvas');
        await expect(canvas).toBeVisible();

        const boundingBox = await canvas.boundingBox();
        const startX = boundingBox.x + 50;
        const startY = boundingBox.y + 50;

        await page.mouse.move(startX, startY);
        await page.mouse.down();
        await page.mouse.move(startX + 100, startY + 100);
        await page.mouse.up();

        const screenshot = await canvas.screenshot();
        fs.writeFileSync('tests/result/test2.png', screenshot);
        expect(await compareImages("tests/result/test2.png", await choseSize("tests/result/test2.png", 2))).toBeTruthy();
    });

    test('should allow changing brush color and thickness', async ({ page }) => {
        const canvas = await page.locator('canvas');
        const colorPicker = await page.locator('#colorPicker');
        const thicknessSlider = await page.locator('#thicknessSlider');

        await expect(colorPicker).toBeVisible();
        await colorPicker.fill('#ff0000');
        await expect(colorPicker).toHaveValue('#ff0000');

        await expect(thicknessSlider).toBeVisible();
        await thicknessSlider.fill('20');
        await expect(thicknessSlider).toHaveValue('20');

        const boundingBox = await canvas.boundingBox();
        const startX = boundingBox.x + 150;
        const startY = boundingBox.y + 150;

        await page.mouse.move(startX, startY);
        await page.mouse.down();
        await page.mouse.move(startX + 100, startY + 100);
        await page.mouse.up();

        const screenshot = await canvas.screenshot();
        fs.writeFileSync('tests/result/test3.png', screenshot);
        expect(await compareImages("tests/result/test3.png", await choseSize("tests/result/test3.png", 3))).toBeTruthy();
    });

    test('should allow clearing the canvas', async ({ page }) => {
        const canvas = await page.locator('canvas');
        const clearButton = await page.locator('#clearCanvas');


        const boundingBox = await canvas.boundingBox();
        const startX = boundingBox.x + 50;
        const startY = boundingBox.y + 50;

        await page.mouse.move(startX, startY);
        await page.mouse.down();
        await page.mouse.move(startX + 100, startY + 100);
        await page.mouse.up();

        await expect(clearButton).toBeVisible();
        await clearButton.click();

        const screenshot = await canvas.screenshot();
        fs.writeFileSync('tests/result/test4.png', screenshot);
        expect(await compareImages("tests/result/test4.png",await choseSize("tests/result/test4.png", 4))).toBeTruthy();
    });

    async function choseSize(path, num) {
        const info = await loadImage(path);
        let testPath = null;
        console.log("Bob");
        if (info.width === 2560) {
            testPath = 'tests/sources/2560x1240/test' + num + '.png';
            console.log("Bob");
        } else {
            testPath = 'tests/sources/1280x620/test' + num + '.png';
        }
        return testPath;

    }

    async function loadImage(path) {
        const { data, info } = await sharp(path)
            .raw()
            .ensureAlpha() // Убедитесь, что альфа-канал добавляется
            .toBuffer({ resolveWithObject: true });
        return { data, info }; // Убедитесь, что вы возвращаете правильные данные
    }

    async function compareImages(imagePath1, imagePath2) {
        const { data: img1Data, info: img1Info } = await loadImage(imagePath1);
        const { data: img2Data, info: img2Info } = await loadImage(imagePath2);


        // Проверяем размеры изображений
        if (img1Info.width !== img2Info.width || img1Info.height !== img2Info.height) {
            console.log(`Размеры изображений: ${img1Info.width}x${img1Info.height} и ${img2Info.width}x${img2Info.height}`);
            throw new Error('Изображения имеют разные размеры и не могут быть сравнены.');
        }


        // Сравниваем изображения
        console.log(`Размеры изображений: ${img1Info.width}x${img1Info.height} и ${img2Info.width}x${img2Info.height}`);
        const numDiffPixels = pixelmatch(img1Data, img2Data, null, img1Info.width, img1Info.height, { threshold: 0.1 });

        // Возвращаем bool, указывающий на наличие отличий
        return numDiffPixels === 0;
    }

});