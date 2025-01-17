/*
 * Copyright (c) 2021 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.app.features.home.room.detail.composer

import im.vector.app.core.platform.VectorViewModelAction
import im.vector.app.features.home.room.detail.composer.voice.VoiceMessageRecorderView
import org.matrix.android.sdk.api.session.room.model.message.MessageAudioContent

sealed class MessageComposerAction : VectorViewModelAction {
    data class SaveDraft(val draft: String) : MessageComposerAction()
    data class SendMessage(val text: CharSequence, val autoMarkdown: Boolean) : MessageComposerAction()
    data class EnterEditMode(val eventId: String, val text: String) : MessageComposerAction()
    data class EnterQuoteMode(val eventId: String, val text: String) : MessageComposerAction()
    data class EnterReplyMode(val eventId: String, val text: String) : MessageComposerAction()
    data class EnterRegularMode(val text: String, val fromSharing: Boolean) : MessageComposerAction()
    data class UserIsTyping(val isTyping: Boolean) : MessageComposerAction()
    data class OnTextChanged(val text: CharSequence) : MessageComposerAction()

    // Voice Message
    data class OnVoiceRecordingUiStateChanged(val uiState: VoiceMessageRecorderView.RecordingUiState) : MessageComposerAction()
    object StartRecordingVoiceMessage : MessageComposerAction()
    data class EndRecordingVoiceMessage(val isCancelled: Boolean) : MessageComposerAction()
    object PauseRecordingVoiceMessage : MessageComposerAction()
    data class PlayOrPauseVoicePlayback(val eventId: String, val messageAudioContent: MessageAudioContent) : MessageComposerAction()
    object PlayOrPauseRecordingPlayback : MessageComposerAction()
    data class EndAllVoiceActions(val deleteRecord: Boolean = true) : MessageComposerAction()
}
