import { createRequire } from 'module';const require = createRequire(import.meta.url);
import {
  MAT_SELECT_CONFIG,
  MAT_SELECT_SCROLL_STRATEGY,
  MAT_SELECT_SCROLL_STRATEGY_PROVIDER,
  MAT_SELECT_SCROLL_STRATEGY_PROVIDER_FACTORY,
  MAT_SELECT_TRIGGER,
  MatSelect,
  MatSelectChange,
  MatSelectModule,
  MatSelectTrigger
} from "./chunk-O44EB4Z5.js";
import "./chunk-FDHWFS34.js";
import "./chunk-GIGYNUX4.js";
import "./chunk-4CI3J4BF.js";
import {
  MatOptgroup,
  MatOption
} from "./chunk-LWP3TRGP.js";
import "./chunk-SJSAW2AD.js";
import "./chunk-7FTWLEFG.js";
import {
  MatError,
  MatFormField,
  MatHint,
  MatLabel,
  MatPrefix,
  MatSuffix
} from "./chunk-OOO4PJJ3.js";
import "./chunk-6METQFLN.js";
import "./chunk-FXXMXUC3.js";
import "./chunk-MLRHMPXF.js";
import "./chunk-ALWOK5YH.js";
import "./chunk-W3HLHDJS.js";
import "./chunk-QWM3MPKG.js";
import "./chunk-V2UQHDV7.js";
import "./chunk-WMCF36ZG.js";
import "./chunk-5XYFHA5V.js";
import "./chunk-WTZGVT66.js";
import "./chunk-PQ6CAPLO.js";
import "./chunk-4NRDWZRV.js";
import "./chunk-C2RSYF2I.js";
import "./chunk-GEVOPQEA.js";
import "./chunk-IOKVTDIT.js";
import "./chunk-YQZF7T32.js";
import "./chunk-MMS7YO36.js";
import {
  require_cjs
} from "./chunk-7SULSMEY.js";
import {
  require_operators
} from "./chunk-JRBTNWFI.js";
import "./chunk-W6MIQTXE.js";
import {
  __toESM
} from "./chunk-YHCV7DAQ.js";

// node_modules/@angular/material/fesm2022/select.mjs
var import_rxjs = __toESM(require_cjs(), 1);
var import_operators = __toESM(require_operators(), 1);
var matSelectAnimations = {
  // Represents
  // trigger('transformPanel', [
  //   state(
  //     'void',
  //     style({
  //       opacity: 0,
  //       transform: 'scale(1, 0.8)',
  //     }),
  //   ),
  //   transition(
  //     'void => showing',
  //     animate(
  //       '120ms cubic-bezier(0, 0, 0.2, 1)',
  //       style({
  //         opacity: 1,
  //         transform: 'scale(1, 1)',
  //       }),
  //     ),
  //   ),
  //   transition('* => void', animate('100ms linear', style({opacity: 0}))),
  // ])
  /** This animation transforms the select's overlay panel on and off the page. */
  transformPanel: {
    type: 7,
    name: "transformPanel",
    definitions: [
      {
        type: 0,
        name: "void",
        styles: {
          type: 6,
          styles: { opacity: 0, transform: "scale(1, 0.8)" },
          offset: null
        }
      },
      {
        type: 1,
        expr: "void => showing",
        animation: {
          type: 4,
          styles: {
            type: 6,
            styles: { opacity: 1, transform: "scale(1, 1)" },
            offset: null
          },
          timings: "120ms cubic-bezier(0, 0, 0.2, 1)"
        },
        options: null
      },
      {
        type: 1,
        expr: "* => void",
        animation: {
          type: 4,
          styles: { type: 6, styles: { opacity: 0 }, offset: null },
          timings: "100ms linear"
        },
        options: null
      }
    ],
    options: {}
  }
};
export {
  MAT_SELECT_CONFIG,
  MAT_SELECT_SCROLL_STRATEGY,
  MAT_SELECT_SCROLL_STRATEGY_PROVIDER,
  MAT_SELECT_SCROLL_STRATEGY_PROVIDER_FACTORY,
  MAT_SELECT_TRIGGER,
  MatError,
  MatFormField,
  MatHint,
  MatLabel,
  MatOptgroup,
  MatOption,
  MatPrefix,
  MatSelect,
  MatSelectChange,
  MatSelectModule,
  MatSelectTrigger,
  MatSuffix,
  matSelectAnimations
};
//# sourceMappingURL=@angular_material_select.js.map
