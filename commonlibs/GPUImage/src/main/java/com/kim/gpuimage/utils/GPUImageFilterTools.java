package com.kim.gpuimage.utils;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.PointF;

import com.kim.gpuimage.GPUImage.OnPictureSavedListener;
import com.kim.gpuimage.GPUImage3x3TextureSamplingFilter;
import com.kim.gpuimage.GPUImageBrightnessFilter;
import com.kim.gpuimage.GPUImageColorInvertFilter;
import com.kim.gpuimage.GPUImageContrastFilter;
import com.kim.gpuimage.GPUImageDissolveBlendFilter;
import com.kim.gpuimage.GPUImageEmbossFilter;
import com.kim.gpuimage.GPUImageExposureFilter;
import com.kim.gpuimage.GPUImageFilter;
import com.kim.gpuimage.GPUImageFilterGroup;
import com.kim.gpuimage.GPUImageGammaFilter;
import com.kim.gpuimage.GPUImageGrayscaleFilter;
import com.kim.gpuimage.GPUImageHighlightShadowFilter;
import com.kim.gpuimage.GPUImageHueFilter;
import com.kim.gpuimage.GPUImageMonochromeFilter;
import com.kim.gpuimage.GPUImageNormalBlendFilter;
import com.kim.gpuimage.GPUImageOpacityFilter;
import com.kim.gpuimage.GPUImageOverlayBlendFilter;
import com.kim.gpuimage.GPUImagePixelationFilter;
import com.kim.gpuimage.GPUImagePosterizeFilter;
import com.kim.gpuimage.GPUImageRGBFilter;
import com.kim.gpuimage.GPUImageSaturationFilter;
import com.kim.gpuimage.GPUImageScreenBlendFilter;
import com.kim.gpuimage.GPUImageSepiaFilter;
import com.kim.gpuimage.GPUImageSharpenFilter;
import com.kim.gpuimage.GPUImageSobelEdgeDetection;
import com.kim.gpuimage.GPUImageSoftLightBlendFilter;
import com.kim.gpuimage.GPUImageTwoInputFilter;
import com.kim.gpuimage.GPUImageView;
import com.kim.gpuimage.GPUImageVignetteFilter;
import com.kim.gpuimage.GPUImageWhiteBalanceFilter;
import com.kim.gpuimage.R;

/**
 * Í¼Æ¬´¦ÀíÊ±Í¼ÊéÐ§¹ûµÄ¹¤¾ßÀà
 * 
 * @author Jack
 * @version ´´½¨Ê±¼ä£º2014-3-16 ÏÂÎç3:51:50
 */
public class GPUImageFilterTools {

	/** Ô­Í¼ **/
	public static final int NONE = 0;
	/** ÈÕÏµ **/
	public static final int JAPEN = 1;
	/** lomo **/
	public static final int LOMO = 2;
	/** Ã÷ **/
	public static final int MING = 3;
	/** Å¯ÑóÑó **/
	public static final int WARM = 4;
	/** ºÚ°× **/
	public static final int BAW = 5;
	/** ÁÁÀö **/
	public static final int BRIGHT = 6;
	/** ·Û÷ì **/
	public static final int PINK = 7;
	/** Á÷Äê **/
	public static final int LIU_NIAN = 8;
	/** ¸´¹Å **/
	public static final int RETRO = 9;
	/** »ØÒä **/
	public static final int MEMORY = 10;
	/** ²ÊÉ«¸¡µñ **/
	public static final int EMBOSS = 11;
	/** ËØ»æ **/
	public static final int SKETCH = 12;
	/** Í¸ÊÓ **/
	public static final int PERSPECTIVE = 13;
	/** Ê·À³¿Ë **/
	public static final int SHREK = 14;
	/** Ó³À¶ **/
	public static final int BLUE = 15;

	/** ´©Ô½ **/
	// public static final int PASS = 4;
	/** ÀÏÕÕÆ¬ **/
	// public static final int OLD = 11;
	/** ´¿Ó¡ **/
	// public static final int STAMP = 12;

	public static GPUImageFilter createFilterForType(final Context context,
			final int type) {
		List<GPUImageFilter> filters = new LinkedList<GPUImageFilter>();
		PointF centerPoint = new PointF();
		centerPoint.x = 0.5f;
		centerPoint.y = 0.5f;
		switch (type) {
		case NONE: // Ô­Í¼
			return new GPUImageContrastFilter(1.0f);
		case RETRO: // ¸´¹Å
			filters.clear();
			filters.add(new GPUImageContrastFilter(1.28519904613495f));
			filters.add(new GPUImageSaturationFilter(1.36462104320526f));
			filters.add(new GPUImageSepiaFilter(0.629963994026184f));
			return new GPUImageFilterGroup(filters);
		case PERSPECTIVE:// Í¸ÊÓ
			filters.clear();
			filters.add(createBlendFilter(context,
					GPUImageNormalBlendFilter.class));
			filters.add(new GPUImageColorInvertFilter());
			filters.add(new GPUImageGrayscaleFilter());
			return new GPUImageFilterGroup(filters);
		case MING: // Ã÷
			filters.clear();
			filters.add(new GPUImageSaturationFilter(0.6750900149345398f));
			filters.add(new GPUImageContrastFilter(1.111912965774536f));
			filters.add(new GPUImageBrightnessFilter(0.03971099853515625f));
			GPUImageHighlightShadowFilter hsFilter = new GPUImageHighlightShadowFilter();
			hsFilter.setShadows(0.2951219379901886f);
			filters.add(hsFilter);
			filters.add(createBlendFilter(context,
					GPUImageNormalBlendFilter.class));
			return new GPUImageFilterGroup(filters);

			// case PASS: // ´©Ô½
			// filters.clear();
			// // filters.add(new
			// GPUImageBrightnessFilter(-0.101083002984524f));
			// // filters.add(new GPUImageGrayscaleFilter());
			// // filters.add(new GPUImageRGBFilter(0.0f, 0.0f,
			// 1.17689502239227f));
			// // filters.add(new GPUImageContrastFilter(1.66787004470825f));
			// return new GPUImageFilterGroup(filters);

		case BAW: // ºÚ°×
			filters.clear();
			filters.add(new GPUImageBrightnessFilter(-0.1010830029845238f));
			filters.add(new GPUImageGrayscaleFilter());

			GPUImageRGBFilter rgbf1 = new GPUImageRGBFilter();
			rgbf1.setBlue(1.176895022392273f);
			filters.add(rgbf1);

			filters.add(new GPUImageContrastFilter(1.667870044708252f));
			filters.add(new GPUImageGammaFilter(0.7039710283279419f));
			filters.add(new GPUImageSepiaFilter(0.5198559761047363f));
			return new GPUImageFilterGroup(filters);

		case SKETCH: // ËØ»æ£¨ÎÄ¼þ×îºóÒ»¸ö£©
			filters.clear();

			GPUImageRGBFilter rgbf = new GPUImageRGBFilter();
			rgbf.setBlue(1.0293f);
			filters.add(rgbf);

			filters.add(new GPUImageGrayscaleFilter());
			filters.add(createBlendFilter(context,
					GPUImageScreenBlendFilter.class, R.drawable.bg_sketch));
			return new GPUImageFilterGroup(filters);

		case SHREK: // Ê·À³¿Ë
			filters.clear();
			filters.add(new GPUImageHueFilter(86.92682647705078f));
			filters.add(new GPUImageSepiaFilter(0.4024390280246735f));
			filters.add(new GPUImageSaturationFilter(2.0f));
			return new GPUImageFilterGroup(filters);

		case PINK: // ·Û÷ì
			filters.clear();
			GPUImageRGBFilter rgbFilter = new GPUImageRGBFilter();
			rgbFilter.setRed(1.156097531318665f);
			rgbFilter.setBlue(1.390243887901306f);
			filters.add(rgbFilter);
			return new GPUImageFilterGroup(filters);

		case EMBOSS: // ²ÊÉ«¸¡µñ
			filters.clear();
			filters.add(new GPUImageEmbossFilter(1.707317113876343f));
			return new GPUImageFilterGroup(filters);

		case BRIGHT: // ÁÁÀö
			filters.clear();
			filters.add(new GPUImageSaturationFilter(0.8048780560493469f));
			filters.add(new GPUImageContrastFilter(1.35609757900238f));
			filters.add(new GPUImageBrightnessFilter(0.05853652954101562f));
			return new GPUImageFilterGroup(filters);

			// case OLD: // ÀÏÕÕÆ¬
			// filters.clear();
			// // filters.add(new GPUImageHazeFilter(0.8048780560493469f));
			// // filters.add(new GPUImageContrastFilter(1.35609757900238f));
			// // filters.add(new
			// GPUImageBrightnessFilter(0.05853652954101562f));
			// return new GPUImageFilterGroup(filters);

			// case STAMP: // ´¿Ó¡
			// filters.clear();
			// // filters.add(new GPUImagePrewittEdgeDetectionFilter());
			// // filters.add(new GPUImageContrastFilter(1.35609757900238f));
			// // filters.add(new
			// GPUImageBrightnessFilter(0.05853652954101562f));
			// return new GPUImageFilterGroup(filters);

		case BLUE: // Ó³À¶
			filters.clear();
			filters.add(new GPUImageRGBFilter(0.1658536642789841f,
					1.360975623130798f, 1.375609755516052f));
			filters.add(createBlendFilter(context,
					GPUImageNormalBlendFilter.class));
			return new GPUImageFilterGroup(filters);

		case JAPEN: // ÈÕÏµ
			filters.clear();
			filters.add(new GPUImageExposureFilter(-0.078f));
			filters.add(new GPUImageContrastFilter(1.5317f));
			filters.add(new GPUImageSaturationFilter(0.6976f));
			filters.add(new GPUImageBrightnessFilter(0.1951f));
			return new GPUImageFilterGroup(filters);

		case MEMORY: // »ØÒä
			filters.clear();
			filters.add(new GPUImageExposureFilter(-0.3122f));
			filters.add(new GPUImageSaturationFilter(1.2049f));
			filters.add(new GPUImageBrightnessFilter(0.039f));
			filters.add(createBlendFilter(context,
					GPUImageNormalBlendFilter.class));
			filters.add(createBlendFilter(context,
					GPUImageOverlayBlendFilter.class));
			return new GPUImageFilterGroup(filters);

		case WARM: // Å¯ÑóÑó
			filters.clear();
			filters.add(new GPUImageExposureFilter(-0.1951f));
			filters.add(new GPUImageContrastFilter(1.0048f));
			filters.add(new GPUImageBrightnessFilter(0.1171f));
			// »ìºÏÂË¾µ
			filters.add(createBlendFilter(context,
					GPUImageSoftLightBlendFilter.class));
			return new GPUImageFilterGroup(filters);

		case LIU_NIAN: // Á÷Äê
			filters.clear();
			filters.add(new GPUImageBrightnessFilter(0.0f));
			return new GPUImageFilterGroup(filters);

		case LOMO: // lomo
			filters.clear();
			filters.add(new GPUImageContrastFilter(2f));
			filters.add(new GPUImageSaturationFilter(1f));
			filters.add(new GPUImageBrightnessFilter(0.068f));
			filters.add(createBlendFilter(context,
					GPUImageNormalBlendFilter.class));
			return new GPUImageFilterGroup(filters);

		default:
			throw new IllegalStateException("No filter of that type!");
		}

	}

	private static GPUImageFilter createBlendFilter(Context context,
			Class<? extends GPUImageTwoInputFilter> filterClass) {
		try {
			GPUImageTwoInputFilter filter = filterClass.newInstance();
			filter.setBitmap(BitmapFactory.decodeResource(
					context.getResources(), R.drawable.gray_marsk));
			return filter;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static GPUImageFilter createBlendFilter(Context context,
			Class<? extends GPUImageTwoInputFilter> filterClass, int drawable) {
		try {
			GPUImageTwoInputFilter filter = filterClass.newInstance();
			filter.setBitmap(BitmapFactory.decodeResource(
					context.getResources(), drawable));
			return filter;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public interface OnGpuImageFilterChosenListener {
		void onGpuImageFilterChosenListener(GPUImageFilter filter);
	}

	private enum FilterType {
		CONTRAST, GRAYSCALE, SHARPEN, SEPIA, SOBEL_EDGE_DETECTION, THREE_X_THREE_CONVOLUTION, FILTER_GROUP, EMBOSS, POSTERIZE, GAMMA, BRIGHTNESS, INVERT, HUE, PIXELATION, SATURATION, EXPOSURE, HIGHLIGHT_SHADOW, MONOCHROME, OPACITY, RGB, WHITE_BALANCE, VIGNETTE, TONE_CURVE, BLEND_COLOR_BURN, BLEND_COLOR_DODGE, BLEND_DARKEN, BLEND_DIFFERENCE, BLEND_DISSOLVE, BLEND_EXCLUSION, BLEND_SOURCE_OVER, BLEND_HARD_LIGHT, BLEND_LIGHTEN, BLEND_ADD, BLEND_DIVIDE, BLEND_MULTIPLY, BLEND_OVERLAY, BLEND_SCREEN, BLEND_ALPHA, BLEND_COLOR, BLEND_HUE, BLEND_SATURATION, BLEND_LUMINOSITY, BLEND_LINEAR_BURN, BLEND_SOFT_LIGHT, BLEND_SUBTRACT, BLEND_CHROMA_KEY, BLEND_NORMAL, LOOKUP_AMATORKA
	}

	private static class FilterList {
		public List<String> names = new LinkedList<String>();
		public List<FilterType> filters = new LinkedList<FilterType>();

		public void addFilter(final String name, final FilterType filter) {
			names.add(name);
			filters.add(filter);
		}
	}

	public static class FilterAdjuster {
		private final Adjuster<? extends GPUImageFilter> adjuster;

		public FilterAdjuster(final GPUImageFilter filter) {
			if (filter instanceof GPUImageSharpenFilter) {
				adjuster = new SharpnessAdjuster().filter(filter);
			} else if (filter instanceof GPUImageSepiaFilter) {
				adjuster = new SepiaAdjuster().filter(filter);
			} else if (filter instanceof GPUImageContrastFilter) {
				adjuster = new ContrastAdjuster().filter(filter);
			} else if (filter instanceof GPUImageGammaFilter) {
				adjuster = new GammaAdjuster().filter(filter);
			} else if (filter instanceof GPUImageBrightnessFilter) {
				adjuster = new BrightnessAdjuster().filter(filter);
			} else if (filter instanceof GPUImageSobelEdgeDetection) {
				adjuster = new SobelAdjuster().filter(filter);
			} else if (filter instanceof GPUImage3x3TextureSamplingFilter) {
				adjuster = new GPU3x3TextureAdjuster().filter(filter);
			} else if (filter instanceof GPUImageEmbossFilter) {
				adjuster = new EmbossAdjuster().filter(filter);
			} else if (filter instanceof GPUImageHueFilter) {
				adjuster = new HueAdjuster().filter(filter);
			} else if (filter instanceof GPUImagePosterizeFilter) {
				adjuster = new PosterizeAdjuster().filter(filter);
			} else if (filter instanceof GPUImagePixelationFilter) {
				adjuster = new PixelationAdjuster().filter(filter);
			} else if (filter instanceof GPUImageSaturationFilter) {
				adjuster = new SaturationAdjuster().filter(filter);
			} else if (filter instanceof GPUImageExposureFilter) {
				adjuster = new ExposureAdjuster().filter(filter);
			} else if (filter instanceof GPUImageHighlightShadowFilter) {
				adjuster = new HighlightShadowAdjuster().filter(filter);
			} else if (filter instanceof GPUImageMonochromeFilter) {
				adjuster = new MonochromeAdjuster().filter(filter);
			} else if (filter instanceof GPUImageOpacityFilter) {
				adjuster = new OpacityAdjuster().filter(filter);
			} else if (filter instanceof GPUImageRGBFilter) {
				adjuster = new RGBAdjuster().filter(filter);
			} else if (filter instanceof GPUImageWhiteBalanceFilter) {
				adjuster = new WhiteBalanceAdjuster().filter(filter);
			} else if (filter instanceof GPUImageVignetteFilter) {
				adjuster = new VignetteAdjuster().filter(filter);
			} else if (filter instanceof GPUImageDissolveBlendFilter) {
				adjuster = new DissolveBlendAdjuster().filter(filter);
			} else {
				adjuster = null;
			}
		}

		public void adjust(final int percentage) {
			if (adjuster != null) {
				adjuster.adjust(percentage);
			}
		}

		private abstract class Adjuster<T extends GPUImageFilter> {
			private T filter;

			@SuppressWarnings("unchecked")
			public Adjuster<T> filter(final GPUImageFilter filter) {
				this.filter = (T) filter;
				return this;
			}

			public T getFilter() {
				return filter;
			}

			public abstract void adjust(int percentage);

			protected float range(final int percentage, final float start,
					final float end) {
				return (end - start) * percentage / 100.0f + start;
			}

			protected int range(final int percentage, final int start,
					final int end) {
				return (end - start) * percentage / 100 + start;
			}
		}

		private class SharpnessAdjuster extends Adjuster<GPUImageSharpenFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setSharpness(range(percentage, -4.0f, 4.0f));
			}
		}

		private class PixelationAdjuster extends
				Adjuster<GPUImagePixelationFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setPixel(range(percentage, 1.0f, 100.0f));
			}
		}

		private class HueAdjuster extends Adjuster<GPUImageHueFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setHue(range(percentage, 0.0f, 360.0f));
			}
		}

		private class ContrastAdjuster extends Adjuster<GPUImageContrastFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setContrast(range(percentage, 0.0f, 2.0f));
			}
		}

		private class GammaAdjuster extends Adjuster<GPUImageGammaFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setGamma(range(percentage, 0.0f, 3.0f));
			}
		}

		private class BrightnessAdjuster extends
				Adjuster<GPUImageBrightnessFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setBrightness(range(percentage, -1.0f, 1.0f));
			}
		}

		private class SepiaAdjuster extends Adjuster<GPUImageSepiaFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setIntensity(range(percentage, 0.0f, 2.0f));
			}
		}

		private class SobelAdjuster extends
				Adjuster<GPUImageSobelEdgeDetection> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setLineSize(range(percentage, 0.0f, 5.0f));
			}
		}

		private class EmbossAdjuster extends Adjuster<GPUImageEmbossFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setIntensity(range(percentage, 0.0f, 4.0f));
			}
		}

		private class PosterizeAdjuster extends
				Adjuster<GPUImagePosterizeFilter> {
			@Override
			public void adjust(final int percentage) {
				// In theorie to 256, but only first 50 are interesting
				getFilter().setColorLevels(range(percentage, 1, 50));
			}
		}

		private class GPU3x3TextureAdjuster extends
				Adjuster<GPUImage3x3TextureSamplingFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setLineSize(range(percentage, 0.0f, 5.0f));
			}
		}

		private class SaturationAdjuster extends
				Adjuster<GPUImageSaturationFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setSaturation(range(percentage, 0.0f, 2.0f));
			}
		}

		private class ExposureAdjuster extends Adjuster<GPUImageExposureFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setExposure(range(percentage, -10.0f, 10.0f));
			}
		}

		private class HighlightShadowAdjuster extends
				Adjuster<GPUImageHighlightShadowFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setShadows(range(percentage, 0.0f, 1.0f));
				getFilter().setHighlights(range(percentage, 0.0f, 1.0f));
			}
		}

		private class MonochromeAdjuster extends
				Adjuster<GPUImageMonochromeFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setIntensity(range(percentage, 0.0f, 1.0f));
				// getFilter().setColor(new float[]{0.6f, 0.45f, 0.3f, 1.0f});
			}
		}

		private class OpacityAdjuster extends Adjuster<GPUImageOpacityFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setOpacity(range(percentage, 0.0f, 1.0f));
			}
		}

		private class RGBAdjuster extends Adjuster<GPUImageRGBFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setRed(range(percentage, 0.0f, 1.0f));
				// getFilter().setGreen(range(percentage, 0.0f, 1.0f));
				// getFilter().setBlue(range(percentage, 0.0f, 1.0f));
			}
		}

		private class WhiteBalanceAdjuster extends
				Adjuster<GPUImageWhiteBalanceFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setTemperature(range(percentage, 2000.0f, 8000.0f));
				// getFilter().setTint(range(percentage, -100.0f, 100.0f));
			}
		}

		private class VignetteAdjuster extends Adjuster<GPUImageVignetteFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setVignetteStart(range(percentage, 0.0f, 1.0f));
			}
		}

		private class DissolveBlendAdjuster extends
				Adjuster<GPUImageDissolveBlendFilter> {
			@Override
			public void adjust(final int percentage) {
				getFilter().setMix(range(percentage, 0.0f, 1.0f));
			}
		}
	}

	/**
	 * Ó¦ÓÃÂË¾µ
	 * 
	 * @param context
	 * @param mGPUImageView
	 * @param filterType
	 */
	public static final void applyFilter(Context context,
			GPUImageView mGPUImageView, int filterType) {
		GPUImageFilter filter = createFilterForType(context, filterType);
		mGPUImageView.setFilter(filter);
		mGPUImageView.requestRender();
	}

	/**
	 * ±£´æÍ¼Æ¬
	 * 
	 * @param mGPUImageView
	 * @param folderName
	 * @param fileName
	 * @param onPictureSavedListener
	 */
	public static final void saveBitmap(GPUImageView mGPUImageView,
			String folderName, String fileName,
			OnPictureSavedListener onPictureSavedListener) {
		mGPUImageView.saveToPictures(folderName, fileName,
				onPictureSavedListener);
	}
}