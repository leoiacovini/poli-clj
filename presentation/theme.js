import theme from 'mdx-deck/themes'

export default {
  ...theme,
  colors: {
    ...theme.colors, // include existing theme colors
    text: 'white',
    link: 'white',
    background: 'rgb(130, 38, 158)',
    code: 'pink',
    codeBackground: 'rgb(130, 38, 158, 0)',
    preBackground:'rgb(130, 38, 158, 0)'
  }
  // Customize your presentation theme here.
  //
  // Read the docs for more info:
  // https://github.com/jxnblk/mdx-deck/blob/master/docs/theming.md
  // https://github.com/jxnblk/mdx-deck/blob/master/docs/themes.md

}
