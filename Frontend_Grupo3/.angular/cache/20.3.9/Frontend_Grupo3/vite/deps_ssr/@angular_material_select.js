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
} from "./chunk-TP4TRISX.js";
import "./chunk-DXTK2HVX.js";
import {
  MatOptgroup,
  MatOption
} from "./chunk-HXW22G7E.js";
import "./chunk-RLRRWZGZ.js";
import "./chunk-FATIZL2R.js";
import "./chunk-W2XQX6QY.js";
import "./chunk-URQECAZE.js";
import {
  MatError,
  MatFormField,
  MatHint,
  MatLabel,
  MatPrefix,
  MatSuffix
} from "./chunk-PWXXIUYL.js";
import "./chunk-4MHCRCIH.js";
import "./chunk-GSFTUQ4G.js";
import "./chunk-FAZ6BXTX.js";
import "./chunk-K4ASK6P4.js";
import "./chunk-RI27K2LT.js";
import "./chunk-2KOWVNF5.js";
import "./chunk-WMCF36ZG.js";
import "./chunk-5XYFHA5V.js";
import "./chunk-C4GUNOZH.js";
import "./chunk-4NRDWZRV.js";
import "./chunk-GMJ7URC2.js";
import "./chunk-6ULE4DQP.js";
import "./chunk-FASNEXSO.js";
import "./chunk-GS74XFDS.js";
import "./chunk-L36C4TB6.js";
import "./chunk-YQZF7T32.js";
import "./chunk-6ZOUBVUJ.js";
import {
  require_operators
} from "./chunk-JRBTNWFI.js";
import {
  require_cjs
} from "./chunk-7SULSMEY.js";
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
