package com.devs.roamance.util;

import com.devs.roamance.config.GeminiModelConfig;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiStreamingChatModel;
import java.util.Objects;
import java.util.function.Consumer;
import org.springframework.stereotype.Component;

@Component
public final class GeminiModelUtil {

  /**
   * Creates a GoogleAiGeminiChatModel with required parameters and additional configuration
   *
   * @param apiKey API key for Google AI services
   * @param modelName Model name to use (e.g., "gemini-pro")
   * @param config Configuration object with model parameters
   * @return Configured ChatLanguageModel instance
   */
  public ChatLanguageModel geminiModelBuilder(
      String apiKey, String modelName, GeminiModelConfig config) {

    Objects.requireNonNull(apiKey, "apiKey must not be null");
    Objects.requireNonNull(modelName, "modelName must not be null");
    Objects.requireNonNull(config, "config must not be null");

    return GoogleAiGeminiChatModel.builder()
        .apiKey(apiKey)
        .modelName(modelName)
        .temperature(config.getTemperature())
        .topP(config.getTopP())
        .topK(config.getTopK())
        .maxOutputTokens(config.getMaxOutputTokens())
        .timeout(config.getTimeout())
        .responseFormat(config.getResponseFormat())
        .safetySettings(config.getSafetySettingsList())
        .build();
  }

  /**
   * Creates a GoogleAiGeminiStreamingChatModel with required parameters and additional
   * configuration
   *
   * @param apiKey API key for Google AI services
   * @param modelName Model name to use (e.g., "gemini-pro")
   * @param config Configuration object with model parameters
   * @return Configured StreamingChatLanguageModel instance
   */
  public StreamingChatLanguageModel geminiStreamingModelBuilder(
      String apiKey, String modelName, GeminiModelConfig config) {

    Objects.requireNonNull(apiKey, "apiKey must not be null");
    Objects.requireNonNull(modelName, "modelName must not be null");
    Objects.requireNonNull(config, "config must not be null");

    return GoogleAiGeminiStreamingChatModel.builder()
        .apiKey(apiKey)
        .modelName(modelName)
        .temperature(config.getTemperature())
        .topP(config.getTopP())
        .topK(config.getTopK())
        .maxOutputTokens(config.getMaxOutputTokens())
        .timeout(config.getTimeout())
        .responseFormat(config.getResponseFormat())
        .safetySettings(config.getSafetySettingsList())
        .build();
  }

  /**
   * Creates a GoogleAiGeminiChatModel with required parameters and default configuration
   *
   * @param apiKey API key for Google AI services
   * @param modelName Model name to use (e.g., "gemini-pro")
   * @return Configured ChatLanguageModel instance
   */
  public ChatLanguageModel geminiModelBuilder(String apiKey, String modelName) {
    return geminiModelBuilder(apiKey, modelName, GeminiModelConfig.builder().build());
  }

  /**
   * Creates a GoogleAiGeminiStreamingChatModel with required parameters and default configuration
   *
   * @param apiKey API key for Google AI services
   * @param modelName Model name to use (e.g., "gemini-pro")
   * @return Configured StreamingChatLanguageModel instance
   */
  public StreamingChatLanguageModel geminiStreamingModelBuilder(String apiKey, String modelName) {
    return geminiStreamingModelBuilder(apiKey, modelName, GeminiModelConfig.builder().build());
  }

  /**
   * Creates a GoogleAiGeminiChatModel with required parameters and customized configuration
   *
   * @param apiKey API key for Google AI services
   * @param modelName Model name to use (e.g., "gemini-pro")
   * @param configCustomizer Consumer to customize the configuration
   * @return Configured ChatLanguageModel instance
   */
  public ChatLanguageModel geminiModelBuilder(
      String apiKey,
      String modelName,
      Consumer<GeminiModelConfig.GeminiModelConfigBuilder> configCustomizer) {

    GeminiModelConfig.GeminiModelConfigBuilder configBuilder = GeminiModelConfig.builder();
    configCustomizer.accept(configBuilder);

    return geminiModelBuilder(apiKey, modelName, configBuilder.build());
  }

  /**
   * Creates a GoogleAiGeminiStreamingChatModel with required parameters and customized
   * configuration
   *
   * @param apiKey API key for Google AI services
   * @param modelName Model name to use (e.g., "gemini-pro")
   * @param configCustomizer Consumer to customize the configuration
   * @return Configured StreamingChatLanguageModel instance
   */
  public StreamingChatLanguageModel geminiStreamingModelBuilder(
      String apiKey,
      String modelName,
      Consumer<GeminiModelConfig.GeminiModelConfigBuilder> configCustomizer) {

    GeminiModelConfig.GeminiModelConfigBuilder configBuilder = GeminiModelConfig.builder();
    configCustomizer.accept(configBuilder);

    return geminiStreamingModelBuilder(apiKey, modelName, configBuilder.build());
  }

  /**
   * Creates a GoogleAiGeminiChatModel with full customization options
   *
   * @param apiKey API key for Google AI services
   * @param modelName Model name to use (e.g., "gemini-pro")
   * @param builderCustomizer Consumer to customize the model builder directly
   * @return Configured ChatLanguageModel instance
   */
  public ChatLanguageModel geminiModelBuilderCustom(
      String apiKey,
      String modelName,
      Consumer<GoogleAiGeminiChatModel.GoogleAiGeminiChatModelBuilder> builderCustomizer) {

    GoogleAiGeminiChatModel.GoogleAiGeminiChatModelBuilder builder =
        GoogleAiGeminiChatModel.builder().apiKey(apiKey).modelName(modelName);

    builderCustomizer.accept(builder);
    return builder.build();
  }

  /**
   * Creates a GoogleAiGeminiStreamingChatModel with full customization options
   *
   * @param apiKey API key for Google AI services
   * @param modelName Model name to use (e.g., "gemini-pro")
   * @param builderCustomizer Consumer to customize the model builder directly
   * @return Configured StreamingChatLanguageModel instance
   */
  public StreamingChatLanguageModel geminiStreamingModelBuilderCustom(
      String apiKey,
      String modelName,
      Consumer<GoogleAiGeminiStreamingChatModel.GoogleAiGeminiStreamingChatModelBuilder>
          builderCustomizer) {

    GoogleAiGeminiStreamingChatModel.GoogleAiGeminiStreamingChatModelBuilder builder =
        GoogleAiGeminiStreamingChatModel.builder().apiKey(apiKey).modelName(modelName);

    builderCustomizer.accept(builder);
    return builder.build();
  }
}
